/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.deposit.api.v1.client;

import io.mifos.core.api.util.CustomFeignClientsConfiguration;
import io.mifos.deposit.api.v1.definition.domain.ProductDefinition;
import io.mifos.deposit.api.v1.definition.domain.ProductDefinitionCommand;
import io.mifos.deposit.api.v1.instance.domain.ProductInstance;
import io.mifos.deposit.api.v1.instance.domain.StateChange;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@FeignClient(value = "deposit-v1", path = "/deposit/v1", configuration = CustomFeignClientsConfiguration.class)
public interface DepositAccountManager {

  @RequestMapping(
      value = "/definitions",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  void create(@RequestBody @Valid final ProductDefinition productDefinition);

  @RequestMapping(
      value = "/definitions",
      method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.ALL_VALUE
  )
  List<ProductDefinition> fetchProductDefinitions();

  @RequestMapping(
      value = "/definitions/{identifier}",
      method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.ALL_VALUE
  )
  ProductDefinition findProductDefinition(@PathVariable("identifier") final String Identifier);

  @RequestMapping(
      value = "/definitions/{identifier}/commands",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  void process(@PathVariable("identifier") final String identifier,
               @RequestBody @Valid final ProductDefinitionCommand command);

  @RequestMapping(
      value = "/instances",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  void create(@RequestBody @Valid final ProductInstance productInstance);

  @RequestMapping(
      value = "/instances",
      method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.ALL_VALUE
  )
  List<ProductInstance> fetchProductInstances(@RequestParam(value = "customer", required = true) final String customer,
                                              @RequestParam(value = "product", required = false) final String product);

  @RequestMapping(
      value = "/instances/{identifier}",
      method = RequestMethod.GET,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.ALL_VALUE
  )
  ProductInstance findProductInstance(@PathVariable("identifier") final String identifier);

  @RequestMapping(
      value = "/instances/{identifier}/states",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  void change(@PathVariable("identifier") final String identifier,
              @RequestBody @Valid final StateChange stateChange);
}