/*
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2016 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.rating.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BLC_RATING_DETAIL")
public class RatingDetailImpl implements RatingDetail {

    @Id
    @GeneratedValue(generator = "RatingDetailId")
    @GenericGenerator(
        name="RatingDetailId",
        strategy="org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
        parameters = {
            @Parameter(name="segment_value", value="RatingDetailImpl"),
            @Parameter(name="entity_name", value="org.broadleafcommerce.core.rating.domain.RatingDetailImpl")
        }
    )
    @Column(name = "RATING_DETAIL_ID")
    private Long id;

    @Column(name = "RATING", nullable = false)
    protected Double rating;

    @Column(name = "RATING_SUBMITTED_DATE", nullable = false)
    protected Date ratingSubmittedDate;

    @Column(name = "CUSTOMER_ID")
    @Index(name="RATING_CUSTOMER_INDEX", columnNames={"CUSTOMER_ID"})
    protected Long customerExternalId;

    @ManyToOne(optional = false, targetEntity = RatingSummaryImpl.class)
    @JoinColumn(name = "RATING_SUMMARY_ID")
    protected RatingSummary ratingSummary;

    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Double getRating() {
        return rating;
    }
    
    @Override
    public void setRating(Double newRating) {
        this.rating = newRating;
    }

    @Override
    public Date getRatingSubmittedDate() {
        return ratingSubmittedDate;
    }
    
    @Override
    public void setRatingSubmittedDate(Date ratingSubmittedDate) {
        this.ratingSubmittedDate = ratingSubmittedDate;
    }

    @Override
    public Long getCustomerExternalId() {
        return customerExternalId;
    }
    
    @Override
    public void setCustomerExternalId(Long customerExternalId) {
        this.customerExternalId = customerExternalId;
    }

    @Override
    public RatingSummary getRatingSummary() {
        return ratingSummary;
    }
    
    @Override
    public void setRatingSummary(RatingSummary ratingSummary) {
        this.ratingSummary = ratingSummary;
    }
    
    
}
