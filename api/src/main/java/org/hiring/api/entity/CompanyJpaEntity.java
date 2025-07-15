package org.hiring.api.entity;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseTimeEntity;

@Entity
@Getter
@Table(name = "company")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CompanyJpaEntity extends BaseTimeEntity {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "industry", nullable = false, length = 100)
    private String industry;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "employee_count", nullable = false)
    private String employeeCount;

    @Column(name = "founded_year", nullable = false)
    private Integer foundedYear;

    @Column(name = "logo_url", length = 255, nullable = false)
    private String logoUrl;

    @Column(name = "website_url", length = 255, nullable = false)
    private String websiteUrl;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobJpaEntity> jobJpaEntities = new ArrayList<>();

    @Builder
    public CompanyJpaEntity(String name, String industry, String description, String employeeCount, Integer foundedYear, String logoUrl, String websiteUrl, String address, List<JobJpaEntity> jobJpaEntities) {
        this.name = name;
        this.industry = industry;
        this.description = description;
        this.employeeCount = employeeCount;
        this.foundedYear = foundedYear;
        this.logoUrl = logoUrl;
        this.websiteUrl = websiteUrl;
        this.address = address;
        this.jobJpaEntities = jobJpaEntities;
    }
}
