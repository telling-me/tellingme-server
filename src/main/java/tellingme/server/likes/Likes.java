package tellingme.server.likes;

import tellingme.server.answer.Answer;
import tellingme.server.user.User;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id", nullable = false)
    private Long likesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
