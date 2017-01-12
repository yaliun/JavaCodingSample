import torrent.dao.TorrentManageDao;;


public class TorrentSearch {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("dd");
		
		TorrentManageDao dao = new TorrentManageDao();
		
		System.out.println(dao.selectConfirmTarget());
		
	}

}
