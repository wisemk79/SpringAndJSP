<script type="txt/javascript">
	var httpRequest = null;
	// ��ü�� ������ ���� ���� ���� ����
	
	function processEvent()
	{
		httpRequest = getXMLHttpRequest();
		//
		httpRequest.onreadystatechange=callbackFunction;
		// Step 3�� �����ϱ� ���� ����
		// ������ ���� ������ �Լ��� �����ϵ��� �Ѵ�.
		//
		httpRequest.open("GET", "/test.txt", true);
		// ù ��° ���� : GET, POST ����
		// �� ��° ���� : ������ URL, 
		//				  ���� �������� ���� �����ο� �־�� �Ѵ�.
		//		GET ��� : "GET", "/test.jsp?id=uid&pwd=1234"
		//		POST��� : "POST", "/test.jsp"
		// �� ��° ���� : ����(sync)/�񵿱�(Async) ����

		httpRequest.send(null);
		//		GET ��� : send(null);
		//		POST��� : send("id=uid&pwd=1234");
	}
</script>