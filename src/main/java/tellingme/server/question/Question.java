package tellingme.server.question;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "title", nullable = false)
    private String title;
}
