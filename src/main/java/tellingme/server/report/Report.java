package tellingme.server.report;

import tellingme.server.answer.Answer;
import tellingme.server.user.User;

import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Long reportId;

    @Column(name = "reason", nullable = false)
    private Integer reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
