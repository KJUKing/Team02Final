package kr.or.ddit.notice.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.NoticeVO;

import java.util.List;

public interface NoticeService {

    /**
     * 공지사항 작성
     * @param notice
     * @return
     */
    public ServiceResult createNotice(NoticeVO notice);

    /**
     * 공지사항 수정
     * @param notice
     * @return
     */
    public ServiceResult modifyNotice(NoticeVO notice);

    /**
     * 공지사항 삭제
     * @param NoticeId
     * @return
     */
    public ServiceResult removeNotice(int NoticeId);

    /**
     * 공지사항 리스트
     * @return
     */
    public List<NoticeVO> readNoticeList(); // Pagination 넣어야함



    public NoticeVO readNoticeDetail(int NoticeId);

}
