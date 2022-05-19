package Order;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrdersItem{

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("color")
	private List<String> color;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("courierId")
	private Object courierId;

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