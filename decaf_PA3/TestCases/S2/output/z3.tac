VTABLE(_Main) {
    <empty>
    Main
}

VTABLE(_NQueues) {
    <empty>
    NQueues
    _NQueues.init;
    _NQueues.solve;
    _NQueues.clearArray;
    _NQueues.printBoard;
    _NQueues.try;
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T14 = 4
    parm _T14
    _T15 =  call _Alloc
    _T16 = VTBL <_Main>
    *(_T15 + 0) = _T16
    return _T15
}

FUNCTION(_NQueues_New) {
memo ''
_NQueues_New:
    _T17 = 24
    parm _T17
    _T18 =  call _Alloc
    _T19 = 0
    _T20 = 4
    _T21 = (_T18 + _T17)
_L16:
    _T22 = (_T21 - _T20)
    _T21 = _T22
    _T23 = (_T17 - _T20)
    _T17 = _T23
    if (_T17 == 0) branch _L17
    *(_T21 + 0) = _T19
    branch _L16
_L17:
    _T24 = VTBL <_NQueues>
    *(_T21 + 0) = _T24
    return _T21
}

FUNCTION(main) {
memo ''
main:
    _T25 =  call _NQueues_New
    _T26 = 2
    parm _T25
    parm _T26
    _T27 = *(_T25 + 0)
    _T28 = *(_T27 + 8)
    _T29 =  call _T28
    parm _T29
    _T30 = *(_T29 + 0)
    _T31 = *(_T30 + 12)
    call _T31
}

FUNCTION(_NQueues.init) {
memo '_T0:4 _T1:8'
_NQueues.init:
    _T32 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T33 = *(_T0 + 8)
    _T34 = *(_T0 + 4)
    _T35 = 0
    _T36 = (_T34 < _T35)
    if (_T36 == 0) branch _L18
    _T37 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T37
    call _PrintString
    call _Halt
_L18:
    _T38 = 4
    _T39 = (_T38 * _T34)
    _T40 = (_T38 + _T39)
    parm _T40
    _T41 =  call _Alloc
    *(_T41 + 0) = _T34
    _T42 = 0
    _T41 = (_T41 + _T40)
_L19:
    _T40 = (_T40 - _T38)
    if (_T40 == 0) branch _L20
    _T41 = (_T41 - _T38)
    *(_T41 + 0) = _T42
    branch _L19
_L20:
    parm _T0
    parm _T41
    _T43 = *(_T0 + 0)
    _T44 = *(_T43 + 16)
    _T45 =  call _T44
    *(_T0 + 8) = _T45
    _T46 = *(_T0 + 12)
    _T47 = *(_T0 + 4)
    _T48 = 0
    _T49 = (_T47 < _T48)
    if (_T49 == 0) branch _L21
    _T50 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T50
    call _PrintString
    call _Halt
_L21:
    _T51 = 4
    _T52 = (_T51 * _T47)
    _T53 = (_T51 + _T52)
    parm _T53
    _T54 =  call _Alloc
    *(_T54 + 0) = _T47
    _T55 = 0
    _T54 = (_T54 + _T53)
_L22:
    _T53 = (_T53 - _T51)
    if (_T53 == 0) branch _L23
    _T54 = (_T54 - _T51)
    *(_T54 + 0) = _T55
    branch _L22
_L23:
    parm _T0
    parm _T54
    _T56 = *(_T0 + 0)
    _T57 = *(_T56 + 16)
    _T58 =  call _T57
    *(_T0 + 12) = _T58
    _T59 = *(_T0 + 16)
    _T60 = *(_T0 + 4)
    _T61 = 0
    _T62 = (_T60 < _T61)
    if (_T62 == 0) branch _L24
    _T63 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T63
    call _PrintString
    call _Halt
_L24:
    _T64 = 4
    _T65 = (_T64 * _T60)
    _T66 = (_T64 + _T65)
    parm _T66
    _T67 =  call _Alloc
    *(_T67 + 0) = _T60
    _T68 = 0
    _T67 = (_T67 + _T66)
_L25:
    _T66 = (_T66 - _T64)
    if (_T66 == 0) branch _L26
    _T67 = (_T67 - _T64)
    *(_T67 + 0) = _T68
    branch _L25
_L26:
    parm _T0
    parm _T67
    _T69 = *(_T0 + 0)
    _T70 = *(_T69 + 16)
    _T71 =  call _T70
    *(_T0 + 16) = _T71
    _T72 = *(_T0 + 20)
    _T73 = *(_T0 + 4)
    _T74 = 0
    _T75 = (_T73 < _T74)
    if (_T75 == 0) branch _L27
    _T76 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T76
    call _PrintString
    call _Halt
_L27:
    _T77 = 4
    _T78 = (_T77 * _T73)
    _T79 = (_T77 + _T78)
    parm _T79
    _T80 =  call _Alloc
    *(_T80 + 0) = _T73
    _T81 = 0
    _T80 = (_T80 + _T79)
_L28:
    _T79 = (_T79 - _T77)
    if (_T79 == 0) branch _L29
    _T80 = (_T80 - _T77)
    *(_T80 + 0) = _T81
    branch _L28
_L29:
    parm _T0
    parm _T80
    _T82 = *(_T0 + 0)
    _T83 = *(_T82 + 16)
    _T84 =  call _T83
    *(_T0 + 20) = _T84
    return _T0
}

FUNCTION(_NQueues.solve) {
memo '_T2:4'
_NQueues.solve:
    _T85 = 0
    _T86 = *(_T2 + 8)
    _T87 = *(_T2 + 12)
    _T88 = *(_T2 + 16)
    _T89 = *(_T2 + 20)
    parm _T2
    parm _T85
    parm _T86
    parm _T87
    parm _T88
    parm _T89
    _T90 = *(_T2 + 0)
    _T91 = *(_T90 + 24)
    call _T91
}

FUNCTION(_NQueues.clearArray) {
memo '_T3:4 _T4:8'
_NQueues.clearArray:
    _T93 = *(_T4 - 4)
    _T94 = 1
    _T95 = (_T93 - _T94)
    _T92 = _T95
_L30:
    _T96 = 0
    _T97 = (_T92 >= _T96)
    if (_T97 == 0) branch _L31
    _T98 = *(_T4 - 4)
    _T99 = (_T92 < _T98)
    if (_T99 == 0) branch _L32
    _T100 = 0
    _T101 = (_T92 < _T100)
    if (_T101 == 0) branch _L33
_L32:
    _T102 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T102
    call _PrintString
    call _Halt
_L33:
    _T103 = 4
    _T104 = (_T92 * _T103)
    _T105 = (_T4 + _T104)
    _T106 = *(_T105 + 0)
    _T107 = 0
    _T108 = 4
    _T109 = (_T92 * _T108)
    _T110 = (_T4 + _T109)
    *(_T110 + 0) = _T107
    branch _L30
_L31:
    return _T4
}

FUNCTION(_NQueues.printBoard) {
memo '_T5:4 _T6:8 _T7:12'
_NQueues.printBoard:
    _T112 = 0
    _T111 = _T112
_L34:
    _T113 = (_T111 < _T7)
    if (_T113 == 0) branch _L35
    _T115 = 0
    _T114 = _T115
_L36:
    _T116 = (_T114 < _T7)
    if (_T116 == 0) branch _L37
    _T117 = *(_T6 - 4)
    _T118 = (_T111 < _T117)
    if (_T118 == 0) branch _L38
    _T119 = 0
    _T120 = (_T111 < _T119)
    if (_T120 == 0) branch _L39
_L38:
    _T121 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T121
    call _PrintString
    call _Halt
_L39:
    _T122 = 4
    _T123 = (_T111 * _T122)
    _T124 = (_T6 + _T123)
    _T125 = *(_T124 + 0)
    _T126 = (_T125 == _T114)
    if (_T126 == 0) branch _L40
    _T127 = 1
    parm _T127
    call _PrintInt
    branch _L41
_L40:
    _T128 = 0
    parm _T128
    call _PrintInt
_L41:
    branch _L36
_L37:
    _T129 = "\n"
    parm _T129
    call _PrintString
    _T130 = 1
    _T131 = (_T111 + _T130)
    _T111 = _T131
    branch _L34
_L35:
}

FUNCTION(_NQueues.try) {
memo '_T8:4 _T9:8 _T10:12 _T11:16 _T12:20 _T13:24'
_NQueues.try:
    _T134 = *(_T11 - 4)
    _T132 = _T134
    _T135 = 0
    _T133 = _T135
    _T136 = (_T9 == _T132)
    if (_T136 == 0) branch _L42
    parm _T8
    parm _T11
    parm _T132
    _T137 = *(_T8 + 0)
    _T138 = *(_T137 + 20)
    call _T138
    branch _L43
_L42:
_L44:
    _T139 = (_T133 < _T132)
    if (_T139 == 0) branch _L45
    _T140 = *(_T10 - 4)
    _T141 = (_T133 < _T140)
    if (_T141 == 0) branch _L46
    _T142 = 0
    _T143 = (_T133 < _T142)
    if (_T143 == 0) branch _L47
_L46:
    _T144 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T144
    call _PrintString
    call _Halt
_L47:
    _T145 = 4
    _T146 = (_T133 * _T145)
    _T147 = (_T10 + _T146)
    _T148 = *(_T147 + 0)
    _T149 = 0
    _T150 = (_T148 == _T149)
    _T151 = (_T133 + _T9)
    _T152 = *(_T12 - 4)
    _T153 = (_T151 < _T152)
    if (_T153 == 0) branch _L48
    _T154 = 0
    _T155 = (_T151 < _T154)
    if (_T155 == 0) branch _L49
_L48:
    _T156 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T156
    call _PrintString
    call _Halt
_L49:
    _T157 = 4
    _T158 = (_T151 * _T157)
    _T159 = (_T12 + _T158)
    _T160 = *(_T159 + 0)
    _T161 = 0
    _T162 = (_T160 == _T161)
    _T163 = (_T150 && _T162)
    _T164 = 1
    _T165 = (_T132 - _T164)
    _T166 = (_T133 + _T165)
    _T167 = (_T166 - _T9)
    _T168 = *(_T13 - 4)
    _T169 = (_T167 < _T168)
    if (_T169 == 0) branch _L50
    _T170 = 0
    _T171 = (_T167 < _T170)
    if (_T171 == 0) branch _L51
_L50:
    _T172 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T172
    call _PrintString
    call _Halt
_L51:
    _T173 = 4
    _T174 = (_T167 * _T173)
    _T175 = (_T13 + _T174)
    _T176 = *(_T175 + 0)
    _T177 = 0
    _T178 = (_T176 == _T177)
    _T179 = (_T163 && _T178)
    if (_T179 == 0) branch _L52
    _T180 = *(_T10 - 4)
    _T181 = (_T133 < _T180)
    if (_T181 == 0) branch _L53
    _T182 = 0
    _T183 = (_T133 < _T182)
    if (_T183 == 0) branch _L54
_L53:
    _T184 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T184
    call _PrintString
    call _Halt
_L54:
    _T185 = 4
    _T186 = (_T133 * _T185)
    _T187 = (_T10 + _T186)
    _T188 = *(_T187 + 0)
    _T189 = 1
    _T190 = 4
    _T191 = (_T133 * _T190)
    _T192 = (_T10 + _T191)
    *(_T192 + 0) = _T189
    _T193 = (_T133 + _T9)
    _T194 = *(_T12 - 4)
    _T195 = (_T193 < _T194)
    if (_T195 == 0) branch _L55
    _T196 = 0
    _T197 = (_T193 < _T196)
    if (_T197 == 0) branch _L56
_L55:
    _T198 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T198
    call _PrintString
    call _Halt
_L56:
    _T199 = 4
    _T200 = (_T193 * _T199)
    _T201 = (_T12 + _T200)
    _T202 = *(_T201 + 0)
    _T203 = 1
    _T204 = 4
    _T205 = (_T193 * _T204)
    _T206 = (_T12 + _T205)
    *(_T206 + 0) = _T203
    _T207 = 1
    _T208 = (_T132 - _T207)
    _T209 = (_T133 + _T208)
    _T210 = (_T209 - _T9)
    _T211 = *(_T13 - 4)
    _T212 = (_T210 < _T211)
    if (_T212 == 0) branch _L57
    _T213 = 0
    _T214 = (_T210 < _T213)
    if (_T214 == 0) branch _L58
_L57:
    _T215 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T215
    call _PrintString
    call _Halt
_L58:
    _T216 = 4
    _T217 = (_T210 * _T216)
    _T218 = (_T13 + _T217)
    _T219 = *(_T218 + 0)
    _T220 = 1
    _T221 = 4
    _T222 = (_T210 * _T221)
    _T223 = (_T13 + _T222)
    *(_T223 + 0) = _T220
    _T224 = *(_T11 - 4)
    _T225 = (_T9 < _T224)
    if (_T225 == 0) branch _L59
    _T226 = 0
    _T227 = (_T9 < _T226)
    if (_T227 == 0) branch _L60
_L59:
    _T228 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T228
    call _PrintString
    call _Halt
_L60:
    _T229 = 4
    _T230 = (_T9 * _T229)
    _T231 = (_T11 + _T230)
    _T232 = *(_T231 + 0)
    _T233 = 4
    _T234 = (_T9 * _T233)
    _T235 = (_T11 + _T234)
    *(_T235 + 0) = _T133
    _T236 = 1
    _T237 = (_T9 + _T236)
    parm _T8
    parm _T237
    parm _T10
    parm _T11
    parm _T12
    parm _T13
    _T238 = *(_T8 + 0)
    _T239 = *(_T238 + 24)
    call _T239
    _T240 = *(_T10 - 4)
    _T241 = (_T133 < _T240)
    if (_T241 == 0) branch _L61
    _T242 = 0
    _T243 = (_T133 < _T242)
    if (_T243 == 0) branch _L62
_L61:
    _T244 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T244
    call _PrintString
    call _Halt
_L62:
    _T245 = 4
    _T246 = (_T133 * _T245)
    _T247 = (_T10 + _T246)
    _T248 = *(_T247 + 0)
    _T249 = 0
    _T250 = 4
    _T251 = (_T133 * _T250)
    _T252 = (_T10 + _T251)
    *(_T252 + 0) = _T249
    _T253 = (_T133 + _T9)
    _T254 = *(_T12 - 4)
    _T255 = (_T253 < _T254)
    if (_T255 == 0) branch _L63
    _T256 = 0
    _T257 = (_T253 < _T256)
    if (_T257 == 0) branch _L64
_L63:
    _T258 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T258
    call _PrintString
    call _Halt
_L64:
    _T259 = 4
    _T260 = (_T253 * _T259)
    _T261 = (_T12 + _T260)
    _T262 = *(_T261 + 0)
    _T263 = 0
    _T264 = 4
    _T265 = (_T253 * _T264)
    _T266 = (_T12 + _T265)
    *(_T266 + 0) = _T263
    _T267 = 1
    _T268 = (_T132 - _T267)
    _T269 = (_T133 + _T268)
    _T270 = (_T269 - _T9)
    _T271 = *(_T13 - 4)
    _T272 = (_T270 < _T271)
    if (_T272 == 0) branch _L65
    _T273 = 0
    _T274 = (_T270 < _T273)
    if (_T274 == 0) branch _L66
_L65:
    _T275 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T275
    call _PrintString
    call _Halt
_L66:
    _T276 = 4
    _T277 = (_T270 * _T276)
    _T278 = (_T13 + _T277)
    _T279 = *(_T278 + 0)
    _T280 = 0
    _T281 = 4
    _T282 = (_T270 * _T281)
    _T283 = (_T13 + _T282)
    *(_T283 + 0) = _T280
_L52:
    _T284 = 1
    _T285 = (_T133 + _T284)
    _T133 = _T285
    branch _L44
_L45:
_L43:
}

