
public class Users {

	private int id;
	private String firstName;
	private String lastName;
	private Preferences preference;
	private Card card;

	public Users() {

	}

	public Users(int id, String firstName, String lastName, Preferences preference, Card card) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preference = preference;
		this.card = card;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", preference=" + preference
				+ ", card=" + card + "]";
	}

	public static void main(String[] args) {
		
		Preferences p = new Preferences(100, 10, 500, 20);
		Card c = new Card("1234-234-345");
		Users u = new Users(324, "Mahendra", "Mhatre", p, c);
		System.out.println(u);

	}

	public String getFirstName() {
		return firstName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
