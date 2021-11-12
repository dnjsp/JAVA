package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	private IBoardService service;
	private Scanner scan;
	private int number;
	
	public BoardController() {
		service = BoardServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new BoardController().startBoard();
	}

	public void startBoard() {

	menu: while (true) {
			displayBoard();
			int displayMenu = displayMenu();
			
			switch (displayMenu) {
				case 1: insert(); break;
				case 2:
					int number = seePost();
					
					switch (number) {
						case 1: updatePost(); break;
						case 2: deletePost(); break;
						case 3:
							System.out.println("리스트로 돌아갑니다...");
							System.out.println();
							System.out.println();
							break;
						case -1: break;
						default:
							System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
							System.out.println();
							System.out.println();
							break;
					}
					
					break;
				case 3: searchTitle(); break;
				case 0:
					System.out.println("작업을 종료합니다.");
					break menu;
				default:
					System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
					System.out.println();
					System.out.println();
					break;
			}
		}
	}

	// 처음 실행 시 게시판 현황을 보여주는 메소드
	private void displayBoard() {
		List<BoardVO> list = service.getAllPostList();

		System.out.println("-------------------------------------------------------");
		System.out.println("No		제 목		작성자		조회수");
		System.out.println("-------------------------------------------------------");

		if (list == null || list.size() == 0) {
			System.out.println("게시글의 정보가 없습니다.");
		} else {
			for (BoardVO boardVO : list) {
				System.out.println(boardVO.getBoard_no() + "\t\t" + boardVO.getBoard_title() + "\t\t"
						+ boardVO.getBoard_writer() + "\t\t" + boardVO.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------");
	}

	// 선택가능 메뉴 보여주는 메소드
	private int displayMenu() {
		System.out.println();
		System.out.println("메뉴 : 1.새글작성	2.게시글보기	3.검색	0.작업끝");
		System.out.print("작업선택>> ");
		int num = scan.nextInt();
		return num;
	}
	
	//게시글 등록 메소드
	private void insert() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("---------------------------");
		System.out.print("제목 >> ");
		String title = scan.next();
		System.out.print("작성자 >> ");
		String writer = scan.next();
		System.out.print("내용 >> ");
		String content = scan.next();
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_title(title);
		boardVO.setBoard_writer(writer);
		boardVO.setBoard_content(content);

		int cnt = service.insertPost(boardVO);

		if (cnt > 0) {
			System.out.println("게시글 추가 완료");
		} else {
			System.out.println("게시글 추가 실패");
		}
	}

	
	//게시물 조회 메소드
	private int seePost() {
		System.out.print("보기를 원하는 게시물 번호 입력>> ");
		number = scan.nextInt();
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_no(number);

		service.updateBoardCnt(number);
		BoardVO board = service.getBoard(boardVO);
		
		if(board.getBoard_writer() != null) {
			System.out.println(board.getBoard_no() + "번글 내용");
			System.out.println("---------------------------------------");
			System.out.println("- 제 목 : " + board.getBoard_title());
			System.out.println("- 작성자 : " + board.getBoard_writer());
			System.out.println("- 내 용 : " + board.getBoard_content());
			System.out.println("- 작성일 : " + board.getBoard_date());
			System.out.println("- 조회수 : " + board.getBoard_cnt());
			return showMenu();
		} else {
			System.out.println("해당하는 게시글이 없습니다.");
			System.out.println();
			System.out.println();
		}
		return -1;
	}
	
	//게시물 수정,삭제 메뉴 보여주는 메소드
	private int showMenu() {
		System.out.println("메뉴 : 1.수정	2.삭제	3.리스트로가기");
		System.out.print("작업선택 >> ");
		int menu = scan.nextInt();

		return menu;

	}
	
	//게시물 수정 메소드
	private void updatePost() {
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-------------------------------");
		System.out.print("- 제 목 : ");
		String updateTitle = scan.next();
		System.out.print("- 내 용 : ");
		String updateContent = scan.next();

		scan.nextLine();
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_title(updateTitle);
		boardVO.setBoard_content(updateContent);
		boardVO.setBoard_no(number);

		int updatePost = service.updatePost(boardVO);

		if (updatePost > 0) {
			System.out.println("수정 완료!");
			System.out.println();
		} else {
			System.out.println("수정 실패!");
			System.out.println();
		}
	}
	
	//게시물 삭제 메소드
	private void deletePost() {
		int deletePost = service.deletePost(number);

		if (deletePost > 0) {
			System.out.println("글이 삭제 되었습니다.");
			System.out.println();
		} else {
			System.out.println("글 삭제가 실패했습니다.");
			
			System.out.println();
		}
	}
	
	//게시물 검색 메소드
	private void searchTitle() {
		System.out.println();
		System.out.println("검색작업");
		System.out.println("------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		String searchTitle = scan.next();
		
		List<BoardVO> list = service.searchBoard(searchTitle);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("No		제 목		작성자		조회수");
		System.out.println("-------------------------------------------------------");

		if (list == null || list.size() == 0) {
			System.out.println("게시글의 정보가 없습니다.");
			System.out.println();
		} else {
			for (BoardVO boardVO : list) {
				System.out.println(boardVO.getBoard_no() + "\t\t" + boardVO.getBoard_title() + "\t\t"
						+ boardVO.getBoard_writer() + "\t\t" + boardVO.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	
	
	

}
