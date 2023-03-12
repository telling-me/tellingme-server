package tellingme.server.user;

import tellingme.server.answer.Answer;
import tellingme.server.likes.Likes;
import tellingme.server.report.Report;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "social_id", nullable = false)
    private String socialId;

    @Column(name = "social_login_type", nullable = false)
    private String socialLoginType;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "allow_notification", nullable = false)
    private Boolean allowNotification;

    @Column(name = "job", nullable = false)
    private Integer job;

    @Column(name = "purpose", nullable = false)
    private Integer purpose;

    @Column(name = "premium_mode", nullable = false)
    private Boolean premiumMode;

    @Column(name = "point", nullable = false)
    private final Integer point = 0;

    @Column(name = "mbti", nullable = true)
    private String mbti;

    @Column(name = "report_count", nullable = false)
    private final Integer reportCount = 0;

    @Column(name = "user_status", nullable = false)
    private final Boolean userStatus = true;

    @Column(name = "withdraw_period", nullable = true)
    private Date withdrawPeriod;

    @OneToMany(mappedBy = "user")
    private List<Answer> answerList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Report> reportList = new ArrayList<>();
}
