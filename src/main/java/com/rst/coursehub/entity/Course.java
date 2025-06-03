package com.rst.coursehub.entity;

import com.rst.coursehub.common.CourseEnums;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", columnDefinition = "ENUM('beginner', 'intermediate', 'advanced')")
    private CourseEnums.CourseLevel level = CourseEnums.CourseLevel.BEGINNER;

    @Column(name = "language", length = 10)
    private String language = "en";

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "discount_price", precision = 10, scale = 2)
    private BigDecimal discountPrice;

    @Column(name= "currency", length = 3)
    private String currency = "USD";

    @Column(name = "thumbnail", length = 500)
    private String thumbnail;

    @Column(name = "preview_video", length = 500)
    private String previewVideo;

    @Column(name = "duration_minutes")
    private Integer durationMinutes = 0;

    @Column(name = "total_lectures")
    private Integer totalLectures = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('draft', 'published', 'archived')")
    private CourseEnums.CourseStatus status = CourseEnums.CourseStatus.DRAFT;

    @Column(name = "is_free")
    private Boolean isFree = false;

    @Column(name = "certificate_available")
    private Boolean certificateAvailable = false;

    @Column(name = "lifetime_access")
    private Boolean lifetimeAccess = true;

    @Column(name = "mobile_access")
    private Boolean mobileAccess = true;

    @Column(name = "downloadable_resources")
    private Boolean downloadableResources = false;

    @Column(name = "average_rating", precision = 3, scale = 2)
    private BigDecimal averageRating;

    @Column(name = "total_reviews")
    private Integer totalReviews = 0;

    @Column(name = "total_enrollments")
    private Integer totalEnrollments = 0;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("sortOrder ASC")
    private List<CourseSection> sections = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();


}
