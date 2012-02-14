# $dirを作成してそこに保存
param($filename, $dir)

mkdir $dir
cat $filename | %{ `
 $data = ($_).Split(" ")
 scala StageMaker ('"{0}"' -f $data[1]) ("{0}\{1}" -f $dir, $data[0])
}
