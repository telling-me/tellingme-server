package tellingme.server.answer;

import tellingme.server.likes.Likes;
import tellingme.server.report.Report;
import tellingme.server.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", nullable = false)
    private Long answerId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "like_count", nullable = false)
    private final Integer likeCount = 0;

    @Column(name = "report_count", nullable = false)
    private final Integer reportCount = 0;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    @Column(name = "modified_time", nullable = true)
    private Date modifiedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "answer")
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany(mappedBy = "answer")
    private List<Report> reportList = new ArrayList<>();
}
