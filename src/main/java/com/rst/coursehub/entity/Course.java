package com.rst.coursehub.entity;

import com.rst.coursehub.common.CourseEnums;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public CourseEnums.CourseLevel getLevel() {
        return level;
    }

    public void setLevel(CourseEnums.CourseLevel level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPreviewVideo() {
        return previewVideo;
    }

    public void setPreviewVideo(String previewVideo) {
        this.previewVideo = previewVideo;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getTotalLectures() {
        return totalLectures;
    }

    public void setTotalLectures(Integer totalLectures) {
        this.totalLectures = totalLectures;
    }

    public CourseEnums.CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseEnums.CourseStatus status) {
        this.status = status;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Boolean getCertificateAvailable() {
        return certificateAvailable;
    }

    public void setCertificateAvailable(Boolean certificateAvailable) {
        this.certificateAvailable = certificateAvailable;
    }

    public Boolean getLifetimeAccess() {
        return lifetimeAccess;
    }

    public void setLifetimeAccess(Boolean lifetimeAccess) {
        this.lifetimeAccess = lifetimeAccess;
    }

    public Boolean getMobileAccess() {
        return mobileAccess;
    }

    public void setMobileAccess(Boolean mobileAccess) {
        this.mobileAccess = mobileAccess;
    }

    public Boolean getDownloadableResources() {
        return downloadableResources;
    }

    public void setDownloadableResources(Boolean downloadableResources) {
        this.downloadableResources = downloadableResources;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Integer getTotalEnrollments() {
        return totalEnrollments;
    }

    public void setTotalEnrollments(Integer totalEnrollments) {
        this.totalEnrollments = totalEnrollments;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
