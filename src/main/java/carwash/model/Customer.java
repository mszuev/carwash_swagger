package carwash.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;

@Entity
@Table(name = "customer")
@Schema(description = "Клиент")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "clientname")
    @Schema(description = "ФИО", example = "Иванов Иван Иванович")
    private String clientName;

    @Column(name = "servicename")
    @Schema(description = "Услуга")
    private String serviceName;

    @Column(name = "time")
    @Schema(description = "Время записи")
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
