package com.example.ionix.adapter.output.db.specification;

import com.example.ionix.adapter.output.db.entity.UserEntity;
import com.example.ionix.entity.user.request.PagedUsersRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserJpaSpecification {

  public Specification<UserEntity> obtainSpecification(PagedUsersRequest pagedUsersRequest) {
    return (root, query, criteriaBuilder) -> Objects.requireNonNull(
      Specification.where(this.findByEnabled()).and(findByEmail(pagedUsersRequest))
        .toPredicate(root, query, criteriaBuilder)
    );
  }

  private Specification<UserEntity> findByEnabled() {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("enabled"), Boolean.TRUE);
  }

  private Specification<UserEntity> findByEmail(PagedUsersRequest pagedUsersRequest) {
    List<Predicate> queryPredicates = new ArrayList<>();
    return (root, query, criteriaBuilder) -> {
      if (StringUtils.isBlank(pagedUsersRequest.getSearchByEmail())) {
        return null;
      }
      queryPredicates.add(criteriaBuilder.equal(root.get("email"),
        pagedUsersRequest.getSearchByEmail().trim().toLowerCase()));
      return criteriaBuilder.or(queryPredicates.toArray(new Predicate[0]));
    };
  }

}
