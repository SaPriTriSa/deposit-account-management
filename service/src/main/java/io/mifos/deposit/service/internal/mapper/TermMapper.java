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
package io.mifos.deposit.service.internal.mapper;

import io.mifos.deposit.api.v1.definition.domain.Term;
import io.mifos.deposit.service.internal.repository.TermEntity;

public class TermMapper {

  private TermMapper() {
    super();
  }

  public static TermEntity map(final Term term) {
    final TermEntity termEntity = new TermEntity();
    termEntity.setPeriod(term.getPeriod());
    termEntity.setTimeUnit(term.getTimeUnit());
    termEntity.setInterestPayable(term.getInterestPayable());

    return termEntity;
  }

  public static Term map(final TermEntity termEntity) {
    final Term term = new Term();
    term.setPeriod(termEntity.getPeriod());
    term.setTimeUnit(termEntity.getTimeUnit());
    term.setInterestPayable(termEntity.getInterestPayable());

    return term;
  }
}