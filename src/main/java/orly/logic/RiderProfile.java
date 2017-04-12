package orly.logic;



import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Serj on 09.04.2017.
 */
@Entity
@Table
public class RiderProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2)
    private String name;

    @Size(min=2)
    private String nickname;

    @Min(8)
    private Integer age;

    public RiderProfile() {
    }

    public RiderProfile(Long id, String name, String nickname, Integer age) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RiderProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiderProfile that = (RiderProfile) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (getNickname() != null ? !getNickname().equals(that.getNickname()) : that.getNickname() != null)
            return false;
        return getAge() != null ? getAge().equals(that.getAge()) : that.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }
}
