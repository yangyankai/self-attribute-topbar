package cn.nbut.mytopbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.nbut.mytopbar.R;

public class Topbar extends RelativeLayout {

	private Button leftBT, rightBT;
	private TextView titleTV;

	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	private float titleTextSize;
	private int titleTextColor;
	private String toptitle;

	// �����������ֲ���
	private LayoutParams leftParams, rightParams, titleParams;

	// ����һ���¼��ӿ�
	public interface topbarClickListener {
		public void leftClick();

		public void rightClick();
	}

	// �����ӿڶ���
	public topbarClickListener listener;

	// ����Ϊ�¼��ӿڸ�ֵ�ķ���
	public void setOnTopbarClickListener(topbarClickListener listener) {
		this.listener = listener;
	}

	// ���췽������ʼ����Ա
	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);

		// ��XML�ж�����Զ�������ӳ�䵽attrs��
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.Topbar);

		// ��ta�ṹ�л�ȡ���ݣ�����һ��key, value�ṹ��ͨ��R��Styleable.Topbar_��������ȡ
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText = ta.getString(R.styleable.Topbar_leftText);

		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);

		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		toptitle = ta.getString(R.styleable.Topbar_toptitle);

		// ������������
		ta.recycle();

		// ��ʼ���ؼ�
		leftBT = new Button(context);
		rightBT = new Button(context);
		titleTV = new TextView(context);

		// ���ÿؼ���ֵ
		leftBT.setTextColor(leftTextColor);
		leftBT.setBackground(leftBackground);
		leftBT.setText(leftText);

		rightBT.setTextColor(rightTextColor);
		rightBT.setBackground(rightBackground);
		rightBT.setText(rightText);

		titleTV.setTextColor(titleTextColor);
		titleTV.setTextSize(titleTextSize);
		titleTV.setText(toptitle);
		titleTV.setGravity(Gravity.CENTER);

		// ����View�ı�����ɫ
		setBackgroundColor(0xFFF59563);

		// ���ò������Ե�width��height
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// ���ö��뷽ʽΪ�����������
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		// ����߰�ť��ӵ���ͼ�У������ò�������
		addView(leftBT, leftParams);

		// ���ò������Ե�width��height
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// ���ö��뷽ʽΪ���������Ҳ�
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		// ����߰�ť��ӵ���ͼ�У������ò�������
		addView(rightBT, rightParams);

		// ���ò������Ե�width��height
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// ���ö��뷽ʽΪ���ж���
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		// ����߰�ť��ӵ���ͼ�У������ò�������
		addView(titleTV, titleParams);
		
		//�����ఴť��Click�¼�
		leftBT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.leftClick();				
			}
		});
		
		//����Ҳఴť��Click�¼�
		rightBT.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				listener.rightClick();
			}
		});

	}
	
	/*
	 * ������߰�ť�Ƿ����أ�true���أ�false��ʧ
	 */
	public void setLeftButtonIsVisiable(boolean flag){
		if(flag){
			leftBT.setVisibility(View.VISIBLE);
		}else{
			leftBT.setVisibility(View.GONE);
		}
	}
	
	/*
	 * �����ұ߰�ť�Ƿ����أ�true���أ�false��ʧ
	 */
	public void setRightButtonIsVisiable(boolean flag){
		if(flag){
			rightBT.setVisibility(View.VISIBLE);
		}else{
			rightBT.setVisibility(View.GONE);
		}
	}
}
