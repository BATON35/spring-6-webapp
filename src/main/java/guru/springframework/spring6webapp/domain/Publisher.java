package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String PublisherName;
    @OneToMany(mappedBy="id")
    private List<Address> address = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", PublisherName='" + PublisherName + '\'' +
                ", address=" + address +
                '}';
    }
}
