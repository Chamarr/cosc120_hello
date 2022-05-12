public class Temperature
{
	//value is in farenheit
	private double value;

public Temperature add( Temperature t) 
	{
		double sum = this.value;
		Temperature tt = new Temperature();
		tt.value = sum;
		return tt;
}	
	public void setFarenheit( double x)
	{
		this.value = x;
	}
	public void setCelsius( double x)
	{
		this.value = x * ((x-32.0) * 5.0 / 9.0);
	}

	public double getFarenheit()
	{
		return this.value;
	}

	public double getCelsius()
	{
		return this.value * (9.0 / 5.0) + 32.0;

}
}