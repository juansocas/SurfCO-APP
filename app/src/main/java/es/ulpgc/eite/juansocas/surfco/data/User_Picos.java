package es.ulpgc.eite.juansocas.surfco.data;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "user_picos",
        foreignKeys = {
            @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId", onDelete = CASCADE),
            @ForeignKey(entity = Picos.class, parentColumns = "id", childColumns = "picoId", onDelete = CASCADE)
        })
public class User_Picos {

    @PrimaryKey
    public int id;


    public int userId;

    public int picoId;


}
