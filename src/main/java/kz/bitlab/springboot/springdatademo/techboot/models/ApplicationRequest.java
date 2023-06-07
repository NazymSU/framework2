package kz.bitlab.springboot.springdatademo.techboot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="applications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "name")
    private  String userName;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "phone")
    private  String phone;
    @Column(name = "handled")
    private  boolean handled;

    @ManyToOne
    private  Course course;
}
