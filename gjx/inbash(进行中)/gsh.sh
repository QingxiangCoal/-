function gsh(){
	for file in `ls $1`
	do
		{ #多线程块
			if [ -d $1"/"$file ] #判断是否为目录
			then
				gsh $1"/"$file #遍历子目录
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

echo "—自动批量缩进格式化脚本—"
echo "注：输入要批量格式化的目录（可以在脚本源码里设置处理的文件后缀）此操作一旦运行不可撤销！（因为多线程太快了，来不及停止）此脚本只追求速度，文件又大又多并且配置不好的慎用（其实是还不会优化）"
read -p"或者输入n退出——" a
if [[ $a == "n" ]]
then
	echo "已退出"
else
	#开始调用
	gsh $a
fi