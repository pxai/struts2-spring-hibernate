/**
 * 
 */
package info.pello.spring.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * The referee of the match
 * @author Pello Xabier Altadill Izura
 * @greetz Undiano Mallenco
 */
public class Referee {
	private String name;
	private String country;

	private Referee assistant1;
	

	private Referee assistant2;
	

	private Referee assistant3;
	
	/**
	 * default constructor
	 */
	public Referee () {
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Referee [" + (name != null ? "name=" + name + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (assistant1 != null ? "assistant1=" + assistant1 + ", " : "")
				+ (assistant2 != null ? "assistant2=" + assistant2 + ", " : "")
				+ (assistant3 != null ? "assistant3=" + assistant3 : "") + "]";
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the assistant1
	 */
	public Referee getAssistant1() {
		return assistant1;
	}

	/**
	 * @param assistant1 the assistant1 to set
	 */
	public void setAssistant1(Referee assistant1) {
		this.assistant1 = assistant1;
	}

	/**
	 * @return the assistant2
	 */
	public Referee getAssistant2() {
		return assistant2;
	}

	/**
	 * @param assistant2 the assistant2 to set
	 */
	public void setAssistant2(Referee assistant2) {
		this.assistant2 = assistant2;
	}

	/**
	 * @return the assistant3
	 */
	public Referee getAssistant3() {
		return assistant3;
	}

	/**
	 * @param assistant3 the assistant3 to set
	 */
	public void setAssistant3(Referee assistant3) {
		this.assistant3 = assistant3;
	}
	
	
}
