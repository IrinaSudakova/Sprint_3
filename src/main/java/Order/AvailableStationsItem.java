package Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvailableStationsItem{

	@JsonProperty("number")
	private String number;

	@JsonProperty("color")
	private String color;

	@JsonProperty("name")
	private String name;
}