class Point
{
	private int Absis;
	private int Ordinat;
	Point()
	{
		Absis = 0;
		Ordinat = 0;
	}
	Point(int x, int y)
	{
		Absis = x;
		Ordinat = y;
	}
	public void SetAbsis(int x)
	{
		Absis = x;
	}
	public void SetOrdinat(int y)
	{
		Ordinat = y;
	}
	public int GetAbsis()
	{
		return Absis;
	}
	public int GetOrdinat()
	{
		return Ordinat;
	}
}