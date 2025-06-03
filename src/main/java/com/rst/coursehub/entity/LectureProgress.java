package com.rst.coursehub.entity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lecture_progress", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"enrollment_id", "lecture_id"})
})
@Data
public class LectureProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    @Column(name = "watch_time")
    private Integer watchTime = 0; // in seconds

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "last_position")
    private Integer lastPosition = 0; // for video resume functionality

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
