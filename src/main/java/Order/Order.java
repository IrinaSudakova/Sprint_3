package Order;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Order{

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("color")
	private List<Object> color;

	@JsonProperty("courierFirstName")
	private String courierFirstName;

	@JsonProperty("finished")
	private boolean finished;

	@JsonProperty("inDelivery")
	private boolean inDelivery;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("cancelled")
	private boolean cancelled;

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("id")
	private int id;

	@JsonProperty("rentTime")
	private int rentTime;

	@JsonProperty("deliveryDate")
	private String deliveryDate;

	@JsonProperty("track")
	private int track;

	@JsonProperty("metroStation")
	private String metroStation;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("status")
	private int status;
}