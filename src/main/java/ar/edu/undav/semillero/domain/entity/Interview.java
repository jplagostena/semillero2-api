package ar.edu.undav.semillero.domain.entity;

import ar.edu.undav.semillero.view.View;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;

/**
 * Connection between Graduated and Company.
 * Reasons: Interviews, Working/worked in that company
 */
@Entity
@Table(name = "interview")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Interview {

    @Id
    @GeneratedValue
    @JsonView(View.Summary.class)
    private Long id;

    @ManyToOne
    @JsonView(View.Summary.class)
    private Graduated graduated;

    @ManyToOne
    @JsonView(View.Summary.class)
    private Company company;

    @Column(name = "fecha")
    @JsonView(View.Summary.class)
    private LocalDate date;

    @Column(name = "Comentarios")
    @JsonView(View.Summary.class)
    private String comments;

    @Column(name = "work_from_date")
    @JsonView(View.Summary.class)
    private LocalDate workFromDate;

    @Column(name = "work_to_date")
    @JsonView(View.Summary.class)
    private LocalDate workToDate;


    public Interview() {
    }

    public Interview(Graduated graduated, Company company, String comments) {
        this.graduated = graduated;
        this.company = company;
        this.comments = comments;
        date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public Graduated getGraduated() {
        return graduated;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getWorkFromDate() {
        return workFromDate;
    }

    public void setWorkFromDate(LocalDate workFromDate) {
        this.workFromDate = workFromDate;
    }

    public LocalDate getWorkToDate() {
        return workToDate;
    }

    public void setWorkToDate(LocalDate workToDate) {
        this.workToDate = workToDate;
    }
}
