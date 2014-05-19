class Node
{
	private Point Titik;
	Node()
	{
		Titik = NULL;
	}
	Node(Point T)
	{
		Titik = T;
	}
	public void SetPoint(Point T)
	{
		Titik = T;
	}
	public Point GetPoint()
	{
		return Titik;
	}
}