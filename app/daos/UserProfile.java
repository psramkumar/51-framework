package daos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by pillai on 4/9/16.
 *
 */
@Data
@Document(collection = "UserProfile")
public class UserProfile implements Serializable {

    @Id
    private String id;
    private String name;

    @Version
    private int version;

    public UserProfile(String name){
        this.name = name;
    }

}
