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
package io.mifos.deposit.service.internal.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shed_charges")
public class ChargeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "action_id", nullable = false)
  private ActionEntity action;
  @Column(name = "income_account_identifier", nullable = false, length = 32)
  private String incomeAccountIdentifier;
  @ManyToOne
  @JoinColumn(name = "product_definition_id", nullable = false)
  private ProductDefinitionEntity productDefinition;
  @Column(name = "a_name", nullable = false)
  private String name;
  @Column(name = "description", nullable = true)
  private String description;
  @Column(name = "proportional", nullable = false)
  private Boolean proportional;
  @Column(name = "amount", nullable = false)
  private Double amount;

  public ChargeEntity() {
    super();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public ActionEntity getAction() {
    return this.action;
  }

  public void setAction(final ActionEntity action) {
    this.action = action;
  }

  public String getIncomeAccountIdentifier() {
    return this.incomeAccountIdentifier;
  }

  public void setIncomeAccountIdentifier(final String incomeAccountIdentifier) {
    this.incomeAccountIdentifier = incomeAccountIdentifier;
  }

  public ProductDefinitionEntity getProductDefinition() {
    return this.productDefinition;
  }

  public void setProductDefinition(final ProductDefinitionEntity productDefinition) {
    this.productDefinition = productDefinition;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Boolean getProportional() {
    return this.proportional;
  }

  public void setProportional(final Boolean proportional) {
    this.proportional = proportional;
  }

  public Double getAmount() {
    return this.amount;
  }

  public void setAmount(final Double amount) {
    this.amount = amount;
  }
}
