package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by samoe on 20/10/2016.
 */

@DatabaseTable(tableName = "user")
public class User {

    @SerializedName("IdUsuario")
    @DatabaseField(id = true)
    private Integer idUsuario;

    @SerializedName("IdPerfil")
    @DatabaseField
    private Integer idPerfil;

    @SerializedName("Usuario")
    @DatabaseField
    private String usuario;

    @SerializedName("accreditor")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private Accreditor accreditor;

    @SerializedName("professor")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private Teacher teacher;

    @SerializedName("investigator")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private Investigator investigator;

    @SerializedName("tut_student")
    private TutStudentForPsp tutStudentForPsp;

    public User(){
    }

    public User(Integer idUsuario, Integer idPerfil, String usuario, Accreditor accreditor, Teacher teacher, Investigator investigator) {
        this.idUsuario = idUsuario;
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.accreditor = accreditor;
        this.teacher = teacher;
        this.investigator = investigator;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Accreditor getAccreditor() {
        return accreditor;
    }

    public void setAccreditor(Accreditor accreditor) {
        this.accreditor = accreditor;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Investigator getInvestigator() {
        return investigator;
    }

    public void setInvestigator(Investigator investigator) {
        this.investigator = investigator;
    }

    public TutStudentForPsp getTutStudentForPsp() {
        return tutStudentForPsp;
    }

    public void setTutStudentForPsp(TutStudentForPsp tutStudentForPsp) {
        this.tutStudentForPsp = tutStudentForPsp;
    }
}
