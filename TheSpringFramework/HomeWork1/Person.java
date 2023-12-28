import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {

    private String firstName;
    private String lastName;
    private int age;


    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
