import torrent.service.TorrentSite;


public class TorrentManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TorrentSite site = new TorrentSite();
		
		try
		{
			// ���� �ٿ�ε��� ������ �غ�
			site.todayContentsInit();
			
			//����Ʈ�� ��Ű�� ����
			//site.getSiteCookie();
			
			// �������� �˻�
			site.getSiteSearchRslt();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
