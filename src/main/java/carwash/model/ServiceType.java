package carwash.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;

@Entity
@Table(name = "services")
@Schema(description = "Услуга")
public class ServiceType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "servicename")
    @Schema(description = "Название услуги", example = "Мойка")
    private String serviceName;

    @Column(name = "cost")
    @Schema(description = "Стоимость", example = "500")
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
