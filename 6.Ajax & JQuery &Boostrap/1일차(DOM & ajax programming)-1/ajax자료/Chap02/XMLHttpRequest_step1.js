<script type="txt/javascript">
	var httpRequest = null;
	// ��ü�� ������ ���� ���� ���� ����

	function getXMLHttpRequest()
	{
		// MS IE�� ActiveX ���·� XMLHttpRequest ��ü ����
		if(window.ActiveXObject)
		{
			// �ֱ� version
			try	{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e){
				// ���� version
				try	{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
				// MS �迭���� ActiveX ��ü�� �������� ���� ���
				catch (e1)	{
					return null;
				} // end of catch e1
			} // end of catch e
		} // end of if block
		// MS IE�� �ƴ� ��� ��ü ����
		else if(window.XMLHttpRequest)
		{
			return new XMLHttpRequest();
		} // end of else-if block
		// XMLHttpRequest�� �������� �ʴ� ���
		else
		{
			return null;
		} // end of last else, if
	} // end of function
</script>