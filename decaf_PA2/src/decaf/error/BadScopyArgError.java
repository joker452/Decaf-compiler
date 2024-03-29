package decaf.error;

import decaf.Location;

/**
 * example：incompatible argument 3: int[] given, int/bool/string expected<br>
 * 3表示发生错误的是第三个参数<br>
 * PA2
 */
public class BadScopyArgError extends DecafError {

	private String id;

	private String type;

	public BadScopyArgError(Location location, String id, String type) {
		super(location);
		this.id= id;
		this.type = type;
	}

	@Override
	protected String getErrMsg() {
		return "incompatible argument " + id + ": " + type
				+ " given, class expected";
	}

}
