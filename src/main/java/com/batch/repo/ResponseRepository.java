package com.batch.repo;

import com.batch.domain.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: MD.Ahmad
 * Date: 1/2/2020 2:47 PM
 */
@Repository
public interface ResponseRepository extends JpaRepository<Response,Long> {

}
