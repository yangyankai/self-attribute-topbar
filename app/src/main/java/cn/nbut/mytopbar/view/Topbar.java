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

	// 定义三个布局参数
	private LayoutParams leftParams, rightParams, titleParams;

	// 定义一个事件接口
	public interface topbarClickListener {
		public void leftClick();

		public void rightClick();
	}

	// 创建接口对象
	public topbarClickListener listener;

	// 创建为事件接口赋值的方法
	public void setOnTopbarClickListener(topbarClickListener listener) {
		this.listener = listener;
	}

	// 构造方法，初始化成员
	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 将XML中定义的自定义属性映射到attrs中
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.Topbar);

		// 从ta结构中获取数据，类似一种key, value结构，通过R。Styleable.Topbar_属性名获取
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText = ta.getString(R.styleable.Topbar_leftText);

		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);

		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		toptitle = ta.getString(R.styleable.Topbar_toptitle);

		// 进行垃圾回收
		ta.recycle();

		// 初始化控件
		leftBT = new Button(context);
		rightBT = new Button(context);
		titleTV = new TextView(context);

		// 设置控件的值
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

		// 设置View的背景颜色
		setBackgroundColor(0xFFF59563);

		// 设置布局属性的width和height
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// 设置对齐方式为父容器的左侧
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		// 将左边按钮添加到视图中，并设置布局属性
		addView(leftBT, leftParams);

		// 设置布局属性的width和height
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// 设置对齐方式为父容器的右侧
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		// 将左边按钮添加到视图中，并设置布局属性
		addView(rightBT, rightParams);

		// 设置布局属性的width和height
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// 设置对齐方式为居中对齐
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		// 将左边按钮添加到视图中，并设置布局属性
		addView(titleTV, titleParams);
		
		//添加左侧按钮的Click事件
		leftBT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.leftClick();				
			}
		});
		
		//添加右侧按钮的Click事件
		rightBT.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				listener.rightClick();
			}
		});

	}
	
	/*
	 * 设置左边按钮是否隐藏，true隐藏，false消失
	 */
	public void setLeftButtonIsVisiable(boolean flag){
		if(flag){
			leftBT.setVisibility(View.VISIBLE);
		}else{
			leftBT.setVisibility(View.GONE);
		}
	}
	
	/*
	 * 设置右边按钮是否隐藏，true隐藏，false消失
	 */
	public void setRightButtonIsVisiable(boolean flag){
		if(flag){
			rightBT.setVisibility(View.VISIBLE);
		}else{
			rightBT.setVisibility(View.GONE);
		}
	}
}
