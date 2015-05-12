/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.jpa.projections;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Oliver Gierke
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * Uses a projection interface to indicate the fields to be returned.
	 * 
	 * @return
	 */
	Collection<CustomerProjection> findAllProjectedBy();

	/**
	 * Uses a concrete DTO type to indicate the fields to be returned. Could use a constructor expression in the query.
	 * 
	 * @return
	 */
	Collection<CustomerDto> findAllDtoedBy();

	/**
	 * Passes in the projection type dynamically (either interface or DTO).
	 * 
	 * @param firstname
	 * @param projection
	 * @return
	 */
	<T> Collection<T> findByFirstname(String firstname, Class<T> projection);
}
