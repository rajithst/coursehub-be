package com.rst.coursehub.entity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import com.rst.coursehub.common.CourseEnums;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lectures")
@Data
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    private CourseSection section;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private CourseEnums.ContentType contentType;

    @Column(name = "video_url", length = 500)
    private String videoUrl;

    @Column(name = "video_duration")
    private Integer videoDuration;

    @Column(name = "article_content", columnDefinition = "LONGTEXT")
    private String articleContent;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @Column(name = "is_preview")
    private Boolean isPreview = false;

    @Column(name = "is_published")
    private Boolean isPublished = true;

    @Column(name = "resources", columnDefinition = "JSON")
    private String resources;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureProgress> lectureProgress = new ArrayList<>();
}
