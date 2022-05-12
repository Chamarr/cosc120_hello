public class Distance
{
  // value is in centimeters
  private double value;

public Distance add( Distance d)
	{
		double sum = this.value + d.value;
		Distance dd = new Distance();
		dd.value = sum;
		return dd;
	}

  public void setCentimeters( double x )
  { 
    this.value = x;
  }

	public void setInches( double x )
	{
		this.value = x * 2.54;
	}

  public double getCentimeters()
  {
    return this.value;
  }
	public double getInches()
	{
		return this.value / 2.54;
	}

}