package chapter09.exercise;

public class CheckBox {
	OnSelectListener listener;
	
	void setOnSelectListener(OnSelectListener listener) {
		this.listener = listener;
	}
	
	void select() {
		listener.onSelect();
	}
	
	// 중첩 인터페이스
	static interface OnSelectListener {
		void onSelect();
	}
}
