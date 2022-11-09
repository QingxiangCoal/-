qjbl="" #全局变量，用来在函数间传递数据
function sz_c_d(){ #主菜单
echo "—主菜单—"
}

function r_e_a_d(){ #读取输入
echo -e "\n"
echo "当前路径："`pwd`
local a=$1"→"
read -p $a fh
if [[ $fh == "exit" ]]
then
exit
elif [[ $fh == "n" ]]
then
l_s
elif [[ $fh == "菜单" ]]
then
sz_c_d
elif [[ $fh == "-1" && $2 == "zcfhsyc" ]] #支持返回上一层
then
cd ../
l_s
else
qjbl=$fh
fi
echo -e "\n"
}

function sc(){ #删除
r_e_a_d "确定删除[$1]？输入：取消/确定"
local fh=$qjbl
if [[ $fh == "确定" ]]
then
if [[ ! -d $HOME/.备份/$(date "+%Y_%m_%d")/ ]]
then
mkdir $HOME/.备份/$(date "+%Y_%m_%d")/
fi
mv $1 $HOME/.备份/$(date "+%Y_%m_%d")/
touch $HOME/.备份/$(date "+%Y_%m_%d")/时间戳.txt >$HOME/.null.txt 2>&1
local sjc=$(date +%s)
echo $sjc > $HOME/.备份/$(date "+%Y_%m_%d")/时间戳.txt
unset sjc
echo "已删除，可在$HOME/.备份/$(date "+%Y_%m_%d")/找到并恢复，5天后如果运行此脚本将自动识别并删除"
fi
unset fh
}

function bf(){ #处理备份文件
{ #使用后台线程
local sj=$(date +%s)
local sjcc=$((sj-432000))
if [[ ! -d $HOME/.备份/ ]]
then
mkdir $HOME/.备份/
fi
for clbf in `ls $HOME/.备份/` #删除大于5天的备份文件
do
{ #多线程处理备份文件
local lj=$HOME/.备份/$clbf/时间戳.txt
sjc=$(cat $lj 2>$HOME/.null.txt)
if [[ $sjcc -lt $sjcc ]]
then
rm -r $HOME/.备份/$clbf
fi
}&
done
wait
}&
}

function v_i_m(){ #vim编辑器检测
echo "vim基本命令："
echo "保存“:w” 退出“:q” 强制退出“:q!” 保存并退出“:wq” 其它命令请自行百度"
r_e_a_d "按回车继续，或者输入n退出" "v_i_m"
vim $1
}

fz_yd="" #复制和移动专用全局变量

function fz(){ #复制
if [[ -d $fz_yd ]]
then
m_l="cp -r " #文件夹
else
m_l="cp " #文件
fi
l_s "f" #复制模式
echo $m_l$fz_yd" "$(pwd)
echo "已复制"$fz_yd"到"$(pwd)
}

function yd(){ #移动
l_s "y" #移动模式
echo "移动"
}

function gsh(){
function gs_h(){
	for file in `ls $1`
	do
		{ #多线程块
			if [ -d $1"/"$file ] #判断是否为目录
			then
				gs_h $1"/"$file #遍历子目录
			else  
				#文件处理
				#只处理的文件后缀
				if [[ $file =~ ".java"$ ]] || [[ $file =~ ".sh"$ ]] || [[ $file =~ ".php"$ ]] || [[ $file =~ ".go"$ ]] || [[ $file =~ ".js"$ ]] || [[ $file =~ ".py"$ ]] || [[ $file =~ ".c"$ ]] || [[ $file =~ ".cpp"$ ]] || [[ $file =~ ".html"$ ]] || [[ $file =~ ".htm"$ ]]
				then
					name=$1"/"$file
					echo "正在处理："$name
					bash gsh_vim.sh $name
				else
					echo $name"文件后缀未指定，不处理"
				fi
			fi
		}&
	done
	wait
}
	#开始调用
	gs_h $1
}

function qx(){ #权限设置
echo "设置权限"
}

function c_d(){ #文件操作菜单
echo $1
echo -e "\n"
echo "—菜单—"
if [[ -d $1 ]]
then
echo "0.打开   1.复制   2.移动   3.删除   4.设置权限   5.关于文件夹   6.隐藏目录(会影响路径)  06.取消选项6   7.隐藏目录下的媒体文件(不会影响路径)  07.取消选项7   8.格式化代码缩进(整个目录下的编程源文件)"
r_e_a_d "输入要选择的序号或者输入n退出" zcfhsyc #支持返回上一层的首字母
local fh=$qjbl
case $fh in
0)
cd $1
;;
1)
fz_yd=`pwd`"/"$1
fz d #dir
;;
2)
yd $1
;;
3)
sc $1
;;
4)
qx $1
;;
5)

;;
6)
mv $1 "."$1
;;
06)
local a=$1
mv $1 ${a:1}
unset a
;;
7)
touch $1/.nomedia
;;
07)
rm -r $1/.nomedia
;;
8)
gsh $1
;;
*)
echo "序号错误！"
esac
else
echo "0.打开(调用vim)   1.复制   2.移动   3.删除   4.设置权限   5.隐藏(会影响路径)  05.取消选项5   6.格式化代码缩进   7.关于此文件"
r_e_a_d "输入要选择的序号或者输入n退出"
local fh=$qjbl
case $fh in
0)
v_i_m $1
;;
1)
fz_yd=`pwd`"/"$1
#fz f #file
;;
2)
yd $1
;;
3)
sc $1
;;
4)
qx $1
;;
5)
mv $1 "."$1
;;
05)
local a=$1
mv $1 ${a:1}
unset a
;;
6)
bash gsh_vim.sh $1 #调用代码格式化脚本
;;
7)

;;
*)
echo "序号错误！"
esac
fi
unset fh
qjbl="" #删除公共变量值
}

function l_s_fh(){ #序号选择
if [[ $2 == "f" || $2 == "c" ]]
then
ts="输入“@”复制/移动到此文件夹，无需退回到目标文件夹的上一层，输入n退出"
else
ts="输入要选择的序号"
fi
r_e_a_d $ts zcfhsyc #支持返回上一层的首字母
unset ts
local fh=$qjbl
echo $fh
if [[ $fh == "@" ]]
then
if [[ $2 == "y" ]]
then
yd
elif [[ $2 == "c" ]]
then
fz
fi
elif [[ $fh -gt $1 || $fh -lt 0 ]]
then
echo "序号错误！"
qjbl=""
l_s_fh $1
fi
unset fh
}

function l_s(){ #循环主体
echo -e "\n"
local i=0
local f="-1.<上一层> "
for file in `ls -A`
do
if [[ -d $file ]] #判断文件夹
then
local a=$i".{"$file"}" #文件夹
else
local a=$i".["$file"]" #文件
fi
local m_l[$i]=$file
((i++))
local f=$f" "$a
done
unset a
unset i
local szcd=${#m_l[@]}
printf "%-18s %-18s\n" $f
unset f
if [[ $1 == "y" || $1 == "c" ]]
then
l_s_fh $szcd $1
else
l_s_fh $szcd
local fh=$qjbl
c_d ${m_l[$fh]}
echo -e "\n"
qjbl="" #删除公共变量值
l_s
fi
unset szcd
unset fh #删除fh变量，否则下一次调用会有bug
}

clear
echo "—简化文件操作脚本—"
echo "非常鸡肋的一个脚本，切勿滥用，可能会产生依赖！功能也少，所以不建议使用。"
echo "在此脚本里删除文件会在home生成“.备份”文件夹，每次运行此脚本会自动删除大于5天的备份文件，可以自行设置时间。"
echo "如果无root权限或者无bash一些功能可能会不能用"
echo "[文件名]是文件，{文件名}是文件夹"
echo "输入-1返回上一层文件夹"
echo "输入exit可退出"
touch $HOME/.null.txt >$HOME/.null.txt 2>&1 #创建错误输出文件
bf #处理备份
l_s #调用主体