package kr.GenAI.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.GenAI.web.entity.Board;

// 유저가 게시글 전체조회를 요청하면 -> Controller -> controller 내부에서는 리스트를 가져오기 위해 Service를 호출
// -> Repository -> Hibernate -> DB접속
// Mapper와 같은 역할!
@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

	
	
}
