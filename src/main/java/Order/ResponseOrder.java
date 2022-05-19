package Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseOrder {

	@JsonProperty("order")
	private Order order;
}